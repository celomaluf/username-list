package br.com.unl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.unl.framework.api.APIResponse;
import br.com.unl.framework.controller.BaseController;
import br.com.unl.model.dto.UNLDTO;
/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Controller
@RequestMapping("user")
public class UNLController extends BaseController {
	
	@RequestMapping(value = "/addUsername", method = RequestMethod.POST)
	public @ResponseBody APIResponse addUsername( @RequestParam(value = "username", required = true) String username) {
		return APIResponse.toOkResponse(UNLDTO.addUsername(username));
	}    
	
	@RequestMapping(value = "/addRestrictedWord", method = RequestMethod.POST)
	public @ResponseBody APIResponse addRestrictedWord( @RequestParam(value = "restrictedWord", required = true) String restrictedWord) {
		return APIResponse.toOkResponse(UNLDTO.addRestrictedWord(restrictedWord));
	}    
	
	@RequestMapping(value = "/getRestrictedWords", method = RequestMethod.GET)
	public @ResponseBody APIResponse getRestrictedWords() {
		return APIResponse.toOkResponse(UNLDTO.getRestrictedWords());
	}    
}
package sample.hibernate4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.hibernate4.service.SampleService;

@Controller
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@GetMapping("/r1")
	@ResponseBody
	public void r1() {
		this.sampleService.request_1();
	}
	
	@GetMapping("/r2")
	@ResponseBody
	public void r2() {
		this.sampleService.request_2();
	}

}

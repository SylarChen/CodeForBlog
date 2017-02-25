package sample.hibernate4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.hibernate4.service.SampleService;

@Controller
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@GetMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public void n_plus_one_problem() {
		this.sampleService.n_plus_one_problem();
	}

}

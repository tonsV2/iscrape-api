package dk.surfstation.iscrape.api.controller;

import dk.surfstation.iscrape.api.resource.PageResource;
import dk.surfstation.iscrape.business.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping("/api")
public class ScrapeController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PageService pageService;


	@RequestMapping(value = "/page", method = POST)
	public String postPage(@RequestBody PageResource pageResource) {
		log.info("postPage()");
		log.info(pageResource.toString());
		return pageResource.toString();
	}

	@RequestMapping(value = "/page/{slug}", method = GET)
	public String getPage(@PathVariable String slug) {
		log.info("getPage({})", slug);

		return pageService.findOne(slug).getContent();
	}
}

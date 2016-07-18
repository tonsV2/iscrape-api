package dk.surfstation.iscrape.api.controller;

import dk.surfstation.iscrape.api.resource.PageResource;
import dk.surfstation.iscrape.business.domain.Page;
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
	public Long postPage(@RequestBody PageResource pageResource) {
		log.info("postPage()");
		log.info(pageResource.toString());
		Page page = new Page(null, pageResource.getSlug(), pageResource.getUrl(), pageResource.getSelector(), pageResource.getContent());
		Page saved = pageService.save(page);
		return saved.getId();
	}

	@RequestMapping(value = "/page/{id}", method = GET)
	public Page getPage(@PathVariable Long id) {
		log.info("getPage({})", id);
		return pageService.findOne(id);
	}

	@RequestMapping(value = "/page/{id}/content", method = GET)
	public String getPageContent(@PathVariable Long id) {
		log.info("getPageContent({})", id);
		return pageService.findOne(id).getContent();
	}

	@RequestMapping(value = "/page", method = GET)
	public Iterable<Page> getAll() {
		log.info("getAll()");
		return pageService.findAll();
	}
}

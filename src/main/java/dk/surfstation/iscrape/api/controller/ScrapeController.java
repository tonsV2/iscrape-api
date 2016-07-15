package dk.surfstation.iscrape.api.controller;

import dk.surfstation.iscrape.api.resource.PageResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

		@RequestMapping(value = "/page", method = POST)
		public String postPage(@RequestBody PageResource pageResource) {
			log.info("postPage()");
			log.info(pageResource.toString());

//			String slug = "dmi-5";
//			String url = "http://www.dmi.dk/hav/udsigter/farvandsudsigter/femdoegnsudsigter/";
//			String selector = "div#c3123.csc-default";
//			PageResource pageResource = new PageResource(slug, url, selector);
			return pageResource.toString();
		}

		@RequestMapping(value = "/page/{slug}", method = GET)
		public String getPage(@PathVariable String slug) {
			log.info("getPage({})", slug);

//			String slug = "dmi-5";
			String url = "http://www.dmi.dk/hav/udsigter/farvandsudsigter/femdoegnsudsigter/";
			String selector = "div#c3123.csc-default";
			PageResource pageResource = new PageResource(slug, url, selector, "<div>content</div>");
			return pageResource.getContent();
		}
}

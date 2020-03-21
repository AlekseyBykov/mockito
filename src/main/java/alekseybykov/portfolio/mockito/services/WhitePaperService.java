package alekseybykov.portfolio.mockito.services;

import alekseybykov.portfolio.mockito.dependencies.external.DocumentService;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class WhitePaperService {

	public WhitePaperService(DocumentService documentService) {
		this.documentService = documentService;
	}

	private DocumentService documentService;

	public List<String> filterWhitePapers(String whitePaperName) {
		List<String> filteredWhitePapers = new ArrayList<>();
		List<String> allWhitePapers = documentService.searchDocumentsByName(whitePaperName);
		for (String whitePaper : allWhitePapers) {
			if (StringUtils.containsIgnoreCase(whitePaper, whitePaperName)) {
				filteredWhitePapers.add(whitePaper);
			}
		}
		return filteredWhitePapers;
	}

	public void deleteWhitePapers(String whitePaperName) {
		List<String> allWhitePapers = documentService.searchDocumentsByName(whitePaperName);
		for (String whitePaper : allWhitePapers) {
			if (StringUtils.containsIgnoreCase(whitePaper, whitePaperName)) {
				documentService.deleteDocumentByName(whitePaper);
			}
		}
	}
}

package gymapp.service;

import java.io.IOException;
import java.util.List;
import gymapp.model.domain.History;
import gymapp.model.resource.HistoryResource;

public class HistoryService implements ServiceInterface<History>{

	private HistoryResource historyResource = null;
	
	public HistoryService() throws IOException {
		this.historyResource = new HistoryResource();
	}
	
	@Override
	public void save(History t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public History find(History t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<History> findAll() throws Exception {
		return historyResource.findAll();
	}

	@Override
	public void upodate(History t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(History t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public List<History> getfilteredHistory() throws Exception {
		List<History> ret = null;
		ret = findAll();

		return ret;
	}
}

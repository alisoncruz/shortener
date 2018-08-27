package br.com.projeto.service;

import java.util.List;

import br.com.projeto.entity.Url;
import br.com.projeto.persistence.UrlDao;
import br.com.projeto.util.AliasUtil;

public class UrlService {
	
	private final UrlDao uDao = new UrlDao();

	private final String baseUrl = "localhost:8080/u/";

	public void create(Url url) throws Exception {

		Url obj = url;
		obj.setAlias(AliasUtil.createAlias());
		isNeededSetHttp(obj);
		obj.setUrlCurta(baseUrl+obj.getAlias());
		uDao.save(obj);

	}

	public List<Url> getList() throws Exception {

		List<Url> list = uDao.findAll();
		return list;
	}
	
	public void delete(Integer cod) throws Exception{
		uDao.delete(cod);
	}
	
	public void update(Url url) throws Exception{
		uDao.update(url);
	}

	
	private void isNeededSetHttp(Url urlObj) {
		if (!urlObj.getUrlNormal().contains("http://")) {
			urlObj.setUrlNormal("http://" + urlObj.getUrlNormal());
		}
	}
	
	
}

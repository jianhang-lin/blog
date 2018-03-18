package work.jianhanglin.spring.boot.blog.vo;

import java.io.Serializable;

import work.jianhanglin.spring.boot.blog.domain.Catalog;

/**
 * Catalog视图实体类
 * 
 * @author linjianhang
 *
 */
public class CatalogVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private Catalog catalog;

	public CatalogVO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

}

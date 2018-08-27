package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Url {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		@XmlAttribute
		private Integer idUrl;

		@Column
		@XmlAttribute
		private String alias;

		@Column
		@XmlAttribute
		private String urlNormal;

		@Column
		@XmlAttribute
		private String urlCurta;

		public Url() {
		}

		public Url(Integer idUrl,String alias, String urlNormal, String urlCurta) {
			this.idUrl= idUrl;
			this.alias = alias;
			this.urlNormal = urlNormal;
			this.urlCurta = urlCurta;
		}

		@Override
		public String toString() {
			return "Url [idUrl=" + idUrl + ", alias=" + alias + ", urlNormal=" + urlNormal + ", urlCurta=" + urlCurta + "]";
		}

		public Integer getIdUrl() {
			return idUrl;
		}

		public void setIdUrl(Integer idUrl) {
			this.idUrl = idUrl;
		}

		public String getAlias() {
			return alias;
		}

		public void setAlias(String alias) {
			this.alias = alias;
		}

		public String getUrlNormal() {
			return urlNormal;
		}

		public void setUrlNormal(String urlNormal) {
			this.urlNormal = urlNormal;
		}

		public String getUrlCurta() {
			return urlCurta;
		}

		public void setUrlCurta(String urlCurta) {
			this.urlCurta = urlCurta;
		}

		
	}

	


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140376.comments;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author i140376
 */
public class Comment implements Serializable {

	/**
	 * The username that made the comment
	 */
	private String userName;

	/**
	 * The text of the comment
	 */
	private String text;
       
	public Comment(String userName, String text) {
		this.userName = userName;
		this.text = text;
		
	}

	/**
	 * Returns the userName of comment
	 *
	 * @return the userName of comment
	 */
	public String userName() {
		return userName;
	}

	/**
	 * Return the text of comment
	 *
	 * @return the text of comment
	 */
	public String text() {
		return text;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Comment other = (Comment) obj;
		return Objects.equals(this.userName, other.userName);
	}
}

	
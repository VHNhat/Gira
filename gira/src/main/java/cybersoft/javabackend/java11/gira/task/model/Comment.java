package cybersoft.javabackend.java11.gira.task.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_comment")
public class Comment extends AbstractEntity {
	@NotBlank
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@OneToMany(mappedBy = "replyFor", cascade = CascadeType.ALL)
	private List<Comment> answers = new LinkedList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Comment replyFor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Task task;
}

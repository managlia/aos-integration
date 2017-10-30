package com.yeti.model.host;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yeti.model.company.Company;

import java.util.List;


/**
 * The persistent class for the host_company database table.
 * 
 */
@Entity
@Table(name="host_company")
@NamedQuery(name="HostCompany.findAll", query="SELECT h FROM HostCompany h")
public class HostCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="company_id")
	private int companyId;

	//bi-directional one-to-one association to Company
	@OneToOne
	@JoinColumn(name="company_id")
	private Company company;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="hostCompany")
	@JsonManagedReference
	private List<User> users;

	public HostCompany() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setHostCompany(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setHostCompany(null);

		return user;
	}

}
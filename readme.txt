create Entity.java
create EntityRepository.java
create IEntityService.java
create IEntityServiceImpl.java
create EntityController.java
---
@Column(name="ListSession_de_formation")
	@OneToMany (mappedBy="formateur")
	private List <Session_de_formation> session_de_formations;
Lahmandi MohamedKarim17:40
@ManyToOne
	private Organisme organisme;
Lahmandi MohamedKarim17:51
@Column(name="ListeUtilisateur")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
    joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles=new HashSet<>();
	---------------
	Faical Yahia17:29
@column(unique = true)
@mail
Lahmandi MohamedKarim17:38
@Column(name="ListSession_de_formation")
	@OneToMany (mappedBy="formateur")
	private List <Session_de_formation> session_de_formations;
Lahmandi MohamedKarim17:40
@ManyToOne
	private Organisme organisme;
Lahmandi MohamedKarim17:51
@Column(name="ListeUtilisateur")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
    joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles=new HashSet<>();
@ManyToMany (mappedBy="roles")
	private Set<Utilisateur> utilisateurs=new HashSet<>();
	
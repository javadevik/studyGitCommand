class PeopleController {

	private final PeopleService service;
	
	public PeopleController(@NotNull PeopleService service) {
		this.service = service;
	}
	
	public List<Person> people() {
		return service.findAll();
	}
	
	public Person index(int id) {
		return service.findById(id);
	}
}

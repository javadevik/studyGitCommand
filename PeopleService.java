@Service
class PeopleService {
	
	private final List<Person> people;
	
	@Autowired
	public PeopleService(@NotNull List<Person> people) {
		this.people = people;
	}
	
	public List<Person> findAll() {
		return people;
	}
	
	public Person findById(int id) {
		return people
			.stream()
			.filter(p -> p.getId == id)
			.findAny()
			.orElseThrow(RuntimeException::new);
	}
}

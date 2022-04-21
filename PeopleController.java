@Controller
@RequestMapping("/people")
class PeopleController {

	private final PeopleService service;
	
	@Autowired
	public PeopleController(@NotNull PeopleService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Person> people() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Person index(@PathVariable("id") int id) {
		return service.findById(id);
	}
}

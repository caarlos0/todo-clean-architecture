package todo.usecases;

import todo.models.Todo;
import todo.repositories.TodoRepository;
import todo.usecases.validators.TodoValidator;

public class ToggleStateUseCase {
	private TodoRepository repository;
	private TodoValidator validator = new TodoValidator();

	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public Todo toggle(Todo todo) {
		validator.validate(todo);
		todo.setDone(!todo.isDone());
		return repository.save(todo);
	}
}

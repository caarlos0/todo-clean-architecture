package todo.usecases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import todo.doubles.TodoRepositorySpy;
import todo.exceptions.InvalidTodoException;
import todo.models.Todo;

public class EditTodoUseCaseTest {
	private EditTodoUseCase interactor;
	private TodoRepositorySpy repository;

	@Before
	public void init() {
		interactor = new EditTodoUseCase();
		repository = new TodoRepositorySpy();
		interactor.setRepository(repository);
	}

	@Test(expected = InvalidTodoException.class)
	public void testEditNullTodo() throws Exception {
		interactor.edit(null);
	}

	@Test(expected = InvalidTodoException.class)
	public void testEditTodoToInvalid() throws Exception {
		interactor.edit(new Todo(""));
	}

	@Test
	public void testEditValid() throws Exception {
		interactor.edit(new Todo("Example"));
		assertThat(repository.hasSaved(), equalTo(true));
	}
}

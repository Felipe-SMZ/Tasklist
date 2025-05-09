package br.edu.fateccotia.tasklist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateccotia.tasklist.model.Task;
import br.edu.fateccotia.tasklist.model.User;
import br.edu.fateccotia.tasklist.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;

	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	public List<Task> findAll() {
		List<Task> list = new ArrayList<Task>();
		taskRepository.findAll()
					  .iterator()
					  .forEachRemaining(list::add);
		return list;
	}

	public List<Task> findByUser(User user) {
		List<Task> list = new ArrayList<Task>();
		taskRepository.findByUser(user)
					  .iterator()
					  .forEachRemaining(list::add);
		return list;
	}

	public List<Task> search(User user, String query) {
		List<Task> list = new ArrayList<Task>();
		taskRepository.findByUserAndDescriptionStartingWithIgnoreCase(user, query)
					  .iterator()
					  .forEachRemaining(list::add);
		return list;
	}

	public Task update(Integer id, Task task) {
		// TODO
		// 1. Resgatar task do banco cujo id é id
		// 2. Atualizar a task resgatada com os dados do parâmetro
		// 3. Salvar no banco as mudanças
		return null;
	}

}

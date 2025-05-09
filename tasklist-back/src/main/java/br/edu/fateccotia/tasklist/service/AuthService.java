package br.edu.fateccotia.tasklist.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateccotia.tasklist.model.Token;
import br.edu.fateccotia.tasklist.model.User;
import br.edu.fateccotia.tasklist.repository.TokenRepository;
import br.edu.fateccotia.tasklist.repository.UserRepository;

@Service
public class AuthService {
	private Integer TOKEN_TTL = 60 * 2;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenRepository tokenRepository;
	
	public void signup(String email, String password) throws Exception {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		Optional<User> userFound = userRepository.findByEmail(email);
		if (userFound.isPresent()) {
			throw new Exception("E-mail already exists");
		}
		
		userRepository.save(user);
	}

	public Token signin(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		Optional<User> userFound = userRepository.findByEmail(email);
		if (userFound.isPresent()
				&& userFound.get().getPassword().equals(password)) {
			Token token = new Token();
			token.setUser(userFound.get());
			token.setToken(UUID.randomUUID().toString()); //TODO Criar logica do token;
			token.setExpirationTime(Instant.now()
					.plusSeconds(TOKEN_TTL)
					.toEpochMilli());
			token = tokenRepository.save(token);
			return token;
		}
		
		return null;
	}

	public Boolean validate(String token) {
		//Resgatar do banco de dados o token ByToken
		//Se existir no banco & a expiração é futura
		//Então é válido
		//Senão, não é válido
		Optional<Token> found = tokenRepository.findByToken(token);
		return found.isPresent()
				&& found.get().getExpirationTime() 
					> Instant.now().toEpochMilli();
	}

	public void signout(String token) {
		Optional<Token> found = tokenRepository.findByToken(token);
		found.ifPresent(t -> {
			t.setExpirationTime(Instant.now().toEpochMilli());
			tokenRepository.save(t);
		});
	}

	public User toUser(String token) {
		Optional<Token> found = tokenRepository.findByToken(token);
		return found.isPresent() ? found.get().getUser() : null;
	}
}

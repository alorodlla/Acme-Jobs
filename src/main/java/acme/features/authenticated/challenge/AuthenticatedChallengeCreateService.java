
package acme.features.authenticated.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.entities.challenges.TipoGoal;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedChallengeCreateService implements AbstractCreateService<Authenticated, Challenge> {

	@Autowired
	private AuthenticatedChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "level", "goalBronze", "rewardBronze", "goalSilver", "rewardSilver", "goalGold", "rewardGold");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		assert request != null;

		Challenge result;
		Date deadline = new Date(System.currentTimeMillis() + 10000);

		result = new Challenge();
		result.setTitle("título de ejemplo");
		result.setDeadline(deadline);
		result.setDescription("lorem ipsum");
		result.setLevel(TipoGoal.BRONZE);
		result.setGoalBronze("Bronze goal");
		result.setGoalSilver("Silver goal");
		result.setGoalGold("Gold goal");
		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}

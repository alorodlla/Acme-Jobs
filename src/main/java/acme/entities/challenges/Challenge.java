
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	// Serialisation identifier ----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	private String				description;

	@Valid
	private TipoGoal			level;

	@NotBlank
	private String				goalBronze;

	@Valid
	private Money				rewardBronze;

	@NotBlank
	private String				goalSilver;

	@Valid
	private Money				rewardSilver;

	@NotBlank
	private String				goalGold;

	@Valid
	private Money				rewardGold;
}

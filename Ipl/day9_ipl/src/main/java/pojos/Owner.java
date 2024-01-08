package pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner extends BaseEntity{

	private int firstName; 
	private int  lastName ;
	private  email ;
}

package logic;

public class Vegetable {
	
	private String _name;

	public Vegetable(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vegetable other = (Vegetable) obj;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
}

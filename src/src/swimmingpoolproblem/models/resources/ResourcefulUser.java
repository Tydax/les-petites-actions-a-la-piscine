package src.swimmingpoolproblem.models.resources;

public class ResourcefulUser<R extends Resource> {

	protected R resource;

	public R getResource() {
		return resource;
	}

	public void setReousrce(R resource) {
		this.resource = resource;
	}

	public void resetResource() {
		this.resource = null;
	}
}

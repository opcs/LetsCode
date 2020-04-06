package com.oops.immutable;

final class ImmEmployee {

	private final int id;
	private Address address;

	// indirect references
	public ImmEmployee(int id, final Address address) {
		this.id = id;
		// use defensive copy to make it immutable
		this.address = new Address(address.getStreetName(), address.getStreetNumber());
	}

	public int getId() {
		return id;
	}

	// indirect references
	public Address getAddress() {
		try {
			return (Address) address.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public String toString() {
		return "ImmEmployee [id=" + id + ", address=" + address + "]";
	}

}

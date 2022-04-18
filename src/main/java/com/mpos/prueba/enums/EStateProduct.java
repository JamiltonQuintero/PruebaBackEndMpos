package com.mpos.prueba.enums;

public enum EStateProduct {
	
	ACTIVE(1, "ACTIVO"),
	INACTIVE(2, "INACTIVO"),
	ELIMINATED(3, "ELIMINADO"),
	SOLD_OUT(4, "AGOTADO");

    private int id;
    /** */
    private String name;
    
	private EStateProduct(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}

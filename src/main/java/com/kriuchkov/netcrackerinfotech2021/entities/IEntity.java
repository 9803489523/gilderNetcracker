package com.kriuchkov.netcrackerinfotech2021.entities;

import java.io.Serializable;

public interface IEntity<PK extends Serializable> extends Serializable {
    PK getId();
}

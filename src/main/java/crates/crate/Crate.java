package crates.crate;

import crates.crate.item.CrateItem;
import crates.crate.type.Rarity;

import java.util.List;

/**
 * Created by Enrique on 14-7-2019.
 * No part of this publication may be reproduced, distributed, or transmitted in any form or by any means.
 * Copyright © 2019 by Enrique
 */
public class Crate {

    private Rarity rarity;
    private List<CrateItem> itemStacks;

    public Crate(Rarity rarity, List<CrateItem> itemStacks) {
        this.rarity = rarity;
        this.itemStacks = itemStacks;
    }
}

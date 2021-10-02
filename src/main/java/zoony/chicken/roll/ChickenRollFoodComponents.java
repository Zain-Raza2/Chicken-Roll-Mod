package zoony.chicken.roll;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import net.minecraft.item.FoodComponent;

public class ChickenRollFoodComponents {
    public static final FoodComponent COOKED_CHICKEN_ROLL = (
    new FoodComponent
    .Builder()
    .hunger(4)
    .saturationModifier(1.5F))
    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 1), 0.5F)
    .meat()
    .build();
}

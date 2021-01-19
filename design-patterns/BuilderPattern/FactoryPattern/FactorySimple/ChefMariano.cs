namespace FactoryPattern.FactorySimple
{
    using System;
    using FactoryPattern.Model;

    public class ChefMariano : GenericSingleton<ChefMariano>
    {
        private ChefMariano()
        {
        }

        public ADish PrepareDish(string dishName)
        {
            switch (dishName)
            {
                case "capriciosa":
                    return new Capriciosa();

                case "latte":
                    return new Coffee(Coffee.CoffeeType.Latte);

                case "bolognese":
                    return new BologneseSpaghetti();

                default:
                    throw new ArgumentException($"Sorry, {dishName} is not yet in our menu. Try next week!");
            }
        }
    }
}

namespace FactoryPattern.FactoryMethods
{
    using FactoryPattern.Model;

    public class CoffeeFactory : GenericSingleton<CoffeeFactory>, IPrepareDrink
    {
        private CoffeeFactory()
        {
        }

        public ADrink PrepareDrink()
        {
            return new Coffee();
        }
    }
}

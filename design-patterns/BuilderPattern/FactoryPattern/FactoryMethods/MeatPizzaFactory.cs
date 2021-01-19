namespace FactoryPattern.FactoryMethods
{
    using FactoryPattern.Model;

    public class MeatPizzaFactory : GenericSingleton<MeatPizzaFactory>, IPrepareFood
    {
        private MeatPizzaFactory()
        {
        }

        public AFood PrepareFood()
        {
            return new Capriciosa();
        }
    }
}

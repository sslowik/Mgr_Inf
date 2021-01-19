namespace FactoryPattern.FactoryMethods
{
    using FactoryPattern.Model;

    public class VegePizzaFactory : GenericSingleton<VegePizzaFactory>, IPrepareFood
    {
        private VegePizzaFactory()
        {
        }

        public AFood PrepareFood()
        {
            return new Margherita();
        }
    }
}

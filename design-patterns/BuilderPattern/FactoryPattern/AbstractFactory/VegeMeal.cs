namespace FactoryPattern.AbstractFactory
{
    using FactoryPattern.Model;

    public class VegeMeal : GenericSingleton<VegeMeal>, IItalianCuisine
    {
        private VegeMeal()
        {
        }

        public APizza MakePizza()
        {
            return new Margherita() { Sauce = APizza.SauceType.Tomato };
        }

        public APasta MakePasta()
        {
            return new PestoSpaghetti();
        }
    }
}

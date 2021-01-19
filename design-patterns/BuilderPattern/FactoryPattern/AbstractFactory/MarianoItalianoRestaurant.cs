namespace FactoryPattern.AbstractFactory
{
    using FactoryPattern.Model;

    public class MarianoItalianoRestaurant
    {
        private readonly IItalianCuisine myChef;

        public MarianoItalianoRestaurant(IItalianCuisine chef)
        {
            this.myChef = chef;
        }

        public (APizza, APasta) PrepareMeal()
        {
            return (this.myChef.MakePizza(), this.myChef.MakePasta());
        }
    }
}

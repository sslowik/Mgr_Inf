namespace FactoryPattern.Model
{
    public class Coffee : ADrink
    {
        public enum CoffeeType
        {
            Espresso = 50,
            Latte = 100,
            Americana = 200
        }

        public int MilkVolume { get; set; } = 0;

        private CoffeeType myType { get; set; }

        public Coffee()
        {
            this.IsAlco = false;
        }

        public Coffee(CoffeeType type)
        {
            this.IsAlco = false;
            this.myType = type;
            this.Volume = (int) type;
        }
    }
}

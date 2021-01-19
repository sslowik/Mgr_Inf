namespace FactoryPattern.Model
{
    public class Whisky : ADrink
    {
        private bool onTheRocks;

        public Whisky()
        {
            this.IsAlco = true;
            this.Volume = 50;
        }

        public Whisky(bool withIce)
        {
            this.IsAlco = true;
            this.Volume = withIce ? 100 : 50;
            this.onTheRocks = withIce;
        }
    }
}

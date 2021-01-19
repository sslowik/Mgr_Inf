namespace FactoryPattern.Model
{
    public class Margherita : APizza
    {
        public bool WithOlive { get; set; }

        public Margherita()
        {
            this.Vege = true;
        }
    }
}

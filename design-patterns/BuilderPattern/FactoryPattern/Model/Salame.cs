namespace FactoryPattern.Model
{
    public class Salame : APizza
    {
        public Salame()
        {
            GlutenFree = false;
            Vege = false;
        }
    }
}

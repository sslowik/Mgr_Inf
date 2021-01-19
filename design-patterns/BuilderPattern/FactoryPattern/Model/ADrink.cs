namespace FactoryPattern.Model
{
    public abstract class ADrink : ADish
    {
        public virtual int Volume { get; set; }
        public virtual bool IsAlco { get; set; }
    }
}

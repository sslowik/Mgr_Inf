namespace FactoryPattern.Model
{
    public abstract class ADish
    {
        public virtual int Price { get; set; }
        public virtual int KiloCals { get; set; } = 0;
    }
}

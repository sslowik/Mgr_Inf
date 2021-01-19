namespace FactoryPattern.Model
{
    public abstract class APasta: AFood
    {
        public virtual bool WithCheese { get; set; } = false;
    }
}

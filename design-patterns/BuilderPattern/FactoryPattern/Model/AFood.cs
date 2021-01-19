namespace FactoryPattern.Model
{
    public abstract class AFood : ADish
    {
        public virtual bool Vege { get; set; }

        public virtual bool GlutenFree { get; set; } = false;
    }
}

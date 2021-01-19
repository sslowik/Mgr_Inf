namespace FactoryPattern.Model
{
    public abstract class APizza: AFood
    {
        public enum SauceType
        {
            Tomato = 0,
            Mayonnaise = 1,
            Garlic = 2,
        }

        public enum DaughType
        {
            Thin = 1,
            Thick = 2,
            Special = 2,
        }

        public int Size { get; set; }

        public SauceType Sauce { get; set; }

        public DaughType Daugh { get; set; } = (DaughType) 1;

        public APizza()
        {
            this.Size = 30;
        }
    }
}

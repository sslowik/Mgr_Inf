const playwright = require('playwright');
const chai = require('chai')
const expect = chai.expect

describe('Smoke tests', function smoketests() {
    this.timeout(60000);
    this.slow(20000);

    let browser;
    let page;

    afterEach(async () => {
        await page.screenshot({
            path: `./screenshots/test-${this.ctx.currentTest.fullTitle()}-${Math.random().toString(36).substr(2, 5)}.png`
        });
        await browser.close();
    });

    ['chromium', 'firefox', 'webkit'].forEach((browserType) => {
        beforeEach(async () => {
            browser = await playwright[browserType].launch();
            const context = await browser.newContext();
            page = await context.newPage();
        });

        it("First test - " + browserType, async () => {
            await page.goto('http://localhost:4100/');
        });

        it("Find element - " + browserType, async () => {
            await page.goto('http://localhost:4100/');
            const element = await page.$("a[href$='login']");

            expect(element).to.not.be.null;
        });
    });
});
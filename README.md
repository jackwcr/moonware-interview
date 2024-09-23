# iOS App Testing with Appium Inspector

This README provides instructions for setting up your environment to test an iOS app using Appium Inspector.

## Prerequisites

Before you begin, ensure you have the following installed on your system:

- **macOS** (for iOS development)
- **Xcode** (latest version)
- **Node.js** (LTS version recommended)
- **Homebrew** (for package management)

## Step 1: Install Xcode

1. Open the App Store on your Mac.
2. Search for "Xcode" and install it.
3. After installation, open Xcode and agree to the license agreement.
4. Install additional components if prompted.

## Step 2: Install Homebrew

If you don’t have Homebrew installed, open your terminal and run:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

## Step 3: Install Appium

You can install Appium via npm (Node Package Manager). In your terminal, run:

```bash
npm install -g appium
```

## Step 4: Install Appium Doctor

Appium Doctor is a helpful tool to verify that all dependencies are installed correctly.

```bash
npm install -g appium-doctor
```

Run Appium Doctor to check your setup:

```bash
appium-doctor
```

Follow any instructions provided to resolve issues.

## Step 5: Install Appium Desktop (Optional)

Appium Desktop includes a graphical interface and inspector.

1. Download Appium Desktop from the [Appium releases page](https://github.com/appium/appium-desktop/releases).
2. Drag the Appium Desktop app to your Applications folder.
3. Launch the Appium Desktop app.

## Step 6: Configure Appium for iOS Testing

1. Start the Appium server by running:

   ```bash
   appium
   ```

2. Open Appium Inspector (if using Appium Desktop) or configure your Appium script to connect to the server.

## Step 7: Set Desired Capabilities in Appium Inspector

When using Appium Inspector, configure the desired capabilities in the following format:

```json
{
  "platformName": "iOS",
  "platformVersion": "<iOS version>",
  "deviceName": "<device name>",
  "app": "<path to your .app or .ipa file>",
  "automationName": "XCUITest"
}
```
Make sure this matches what is declared in IOSAppiumTest

## Step 8: Create an env file

1. Make sure to create a .env file to hold your secrets (currently only supporting email and password)
2. This should connect with the config file

## Step 9: Run your Xcode project

Run your project in Xcode withe same iOS device for testing

## Step 10: Start Testing

1. Use Appium Inspector to explore your app’s UI and create test scripts.
2. Run your tests using the Appium server.

## Troubleshooting

If you encounter issues, consult the following:

- Appium documentation: [Appium Documentation](http://appium.io/docs/en/about-appium/intro/)
- Appium GitHub issues: [Appium GitHub](https://github.com/appium/appium/issues)

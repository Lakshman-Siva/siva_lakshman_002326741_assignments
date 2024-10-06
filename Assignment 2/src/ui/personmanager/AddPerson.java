/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.personmanager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Person;
import model.PersonDirectory;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Lakshman
 */
public class AddPerson extends javax.swing.JPanel {
	
	private JPanel mainFramePanel;
	private PersonDirectory personDirectory;
	private String token;

	/**
	 * Creates new form AddPerson
	 */
	public AddPerson(JPanel panel, PersonDirectory pd) {
		initComponents();
		scrollPane.getVerticalScrollBar().setUnitIncrement(20); // Adjusting the scroll speed.
		
		personDirectory = pd;
		mainFramePanel = panel;
		
		try {
			token = null;
			getToken();
		} catch (Exception ex) {}
		
		System.out.println(token);
	}
	
	private void getToken() throws Exception {
		URL url = new URL("https://www.universal-tutorial.com/api/getaccesstoken");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		// Set required headers
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("api-token", "2EVX43Xlw7Cs6_0WkgjGbKEqv9Onnm6wSG2x4SptBKGE1qUeETg36toInDWG_GUggN8");
		con.setRequestProperty("user-email", "slakshman664@gmail.com");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		System.out.println(response.toString());
		JSONObject jsonResponse = new JSONObject(response.toString());
		token = jsonResponse.getString("auth_token");
	}
	
	private Object sendGetRequest(String apiUrl) throws Exception {
		if(token == null) {
			return null;
		}
		URL url = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		// Set required headers
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Authorization",  "Bearer " + token);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		System.out.println(response.toString());
		
		return response;
	}
	
	private boolean isEmpty(Object field) {
		return field == null || field.toString().trim().equalsIgnoreCase("-- Select --") || field.toString().trim().isEmpty();
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Field Validation", JOptionPane.WARNING_MESSAGE);
	}
	
	public  boolean isFormValid() {
		// Personal Info Validation
		if (isEmpty(firstName.getText())) {
			showMessage("First Name is mandatory.");
			return false;
		}
		if (isEmpty(lastName.getText())) {
			showMessage("Last Name is mandatory.");
			return false;
		}
		if (isEmpty(dob.getDate())) {
			showMessage("Date is mandatory.");
			return false;
		}
		if (isEmpty(ssn.getText())) {
			showMessage("Social Security Number is mandatory.");
			return false;
		}
		if (isEmpty(age.getValue())) {
			showMessage("Age is mandatory.");
			return false;
		}
		if (isEmpty(salary.getText())) {
			showMessage("Salary is mandatory.");
			return false;
		}
		if (isEmpty(creditScore.getValue())) {
			showMessage("Social Security Number is mandatory.");
			return false;
		}
		
		// Home address validation
		if (isEmpty(homeAddressLine1.getText())) {
			showMessage("Home Address Line 1 is mandatory.");
			return false;
		}
		if (isEmpty(homeAddressLine2.getText())) {
			showMessage("Home Address Line 2 is mandatory.");
			return false;
		}
		if (isEmpty(homeUnit.getText())) {
			showMessage("Home Unit Number is mandatory.");
			return false;
		}
		if (isEmpty(homeZip.getText())) {
			showMessage("Home Zip Code is mandatory.");
			return false;
		}
		if (isEmpty(homeCountry.getSelectedItem())) {
			showMessage("Home Country is mandatory.");
			return false;
		}
		if (isEmpty(homeState.getSelectedItem())) {
			showMessage("Home State is mandatory.");
			return false;
		}
		if (isEmpty(homeCity.getSelectedItem())) {
			showMessage("Home City is mandatory.");
			return false;
		}
		if (isEmpty(homePhone.getText())) {
			showMessage("Home Phone Number is mandatory.");
			return false;
		}
		
		// Work address validation
		if (isEmpty(workAddressLine1.getText())) {
			showMessage("Work Address Line 1 is mandatory.");
			return false;
		}
		if (isEmpty(workAddressLine2.getText())) {
			showMessage("Work Address Line 2 is mandatory.");
			return false;
		}
		if (isEmpty(workUnit.getText())) {
			showMessage("Work Unit Number is mandatory.");
			return false;
		}
		if (isEmpty(workZip.getText())) {
			showMessage("Work Zip Code is mandatory.");
			return false;
		}
		if (isEmpty(workCountry.getSelectedItem())) {
			showMessage("Work Country is mandatory.");
			return false;
		}
		if (isEmpty(workState.getSelectedItem())) {
			showMessage("Work State is mandatory.");
			return false;
		}
		if (isEmpty(workCity.getSelectedItem())) {
			showMessage("Work City is mandatory.");
			return false;
		}
		if (isEmpty(workPhone.getText())) {
			showMessage("Work Phone Number is mandatory.");
			return false;
		}
		
		try {
			if(Double.parseDouble(salary.getText()) <= 0) {
				showMessage("Salary cannot be less than 0. Please try again!");
				return false;
			}
		} catch (Exception ex) {
			showMessage("Please enter a valid salary!");
			return false;
		}
		
		try {
			if(Long.parseLong(ssn.getText()) <= 100000000) {
				showMessage("Please enter a valid Social Security Number");
				return false;
			}
		} catch (Exception ex) {
				showMessage("Please enter a valid Social Security Number");
			return false;
		}
		
		// If all mandatory fields are filled
		return true;
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        topPanel = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        formContainerPanel = new javax.swing.JPanel();
        homeAddressPanel = new javax.swing.JPanel();
        homeAddressHelper = new javax.swing.JLabel();
        homeAddressTitle = new javax.swing.JLabel();
        homeAddressLine1 = new javax.swing.JTextField();
        homeAddressLine1Label = new javax.swing.JLabel();
        homeAddressLine2Label = new javax.swing.JLabel();
        homeAddressLine2 = new javax.swing.JTextField();
        homeUnitLabel = new javax.swing.JLabel();
        homeUnit = new javax.swing.JTextField();
        homeZipLabel = new javax.swing.JLabel();
        homeZip = new javax.swing.JTextField();
        homeCountryLabel = new javax.swing.JLabel();
        homeStateLabel = new javax.swing.JLabel();
        homeCityLabel = new javax.swing.JLabel();
        homeCountry = new javax.swing.JComboBox<>();
        homeState = new javax.swing.JComboBox<>();
        homeCity = new javax.swing.JComboBox<>();
        homePhone = new javax.swing.JTextField();
        homePhoneLabel = new javax.swing.JLabel();
        personalInfoPanel = new javax.swing.JPanel();
        personalInfoTitle = new javax.swing.JLabel();
        personalInfoHelper = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        dobLabel = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        ageLabel = new javax.swing.JLabel();
        age = new javax.swing.JSpinner();
        ssnLabel = new javax.swing.JLabel();
        ssn = new javax.swing.JTextField();
        isMarried = new javax.swing.JCheckBox();
        salaryLabel = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        creditScoreLabel = new javax.swing.JLabel();
        creditScore = new javax.swing.JSpinner();
        workAddressPanel = new javax.swing.JPanel();
        workAddressTitle = new javax.swing.JLabel();
        workAddressHelper = new javax.swing.JLabel();
        workAddressLine1Label = new javax.swing.JLabel();
        workAddressLine1 = new javax.swing.JTextField();
        workAddressLine2Label = new javax.swing.JLabel();
        workAddressLine2 = new javax.swing.JTextField();
        workUnitLabel = new javax.swing.JLabel();
        workUnit = new javax.swing.JTextField();
        workZipLabel = new javax.swing.JLabel();
        workZip = new javax.swing.JTextField();
        workCountryLabel = new javax.swing.JLabel();
        workCountry = new javax.swing.JComboBox<>();
        workStateLabel = new javax.swing.JLabel();
        workState = new javax.swing.JComboBox<>();
        workCityLabel = new javax.swing.JLabel();
        workCity = new javax.swing.JComboBox<>();
        workPhoneLabel = new javax.swing.JLabel();
        workPhone = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();

        splitPane.setDividerSize(0);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 240)));
        topPanel.setPreferredSize(new java.awt.Dimension(790, 50));

        backBtn.setBackground(new java.awt.Color(0, 0, 0));
        backBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back-arrow.png"))); // NOI18N
        backBtn.setText("Back");
        backBtn.setBorder(null);
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        backBtn.setIconTextGap(5);
        backBtn.setMargin(new java.awt.Insets(10, 14, 3, 14));
        backBtn.setVerifyInputWhenFocusTarget(false);
        backBtn.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
        });
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        heading.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        heading.setForeground(new java.awt.Color(0, 0, 0));
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Add Person");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(heading))
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        splitPane.setTopComponent(topPanel);

        scrollPane.setBackground(new java.awt.Color(0, 204, 204));
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new java.awt.Dimension(790, 650));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(790, 1480));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10);
        flowLayout1.setAlignOnBaseline(true);
        mainPanel.setLayout(flowLayout1);

        formContainerPanel.setBackground(new java.awt.Color(255, 255, 255));
        formContainerPanel.setPreferredSize(new java.awt.Dimension(650, 1400));
        formContainerPanel.setLayout(new java.awt.BorderLayout(0, 20));

        homeAddressPanel.setBackground(new java.awt.Color(255, 255, 255));
        homeAddressPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));
        homeAddressPanel.setPreferredSize(new java.awt.Dimension(650, 440));

        homeAddressHelper.setText("Enter the person's home address details");

        homeAddressTitle.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        homeAddressTitle.setForeground(new java.awt.Color(0, 0, 0));
        homeAddressTitle.setText("Home Address");

        homeAddressLine1.setBackground(new java.awt.Color(255, 255, 255));
        homeAddressLine1.setToolTipText("Enter the Address Line 1");
        homeAddressLine1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        homeAddressLine1Label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        homeAddressLine1Label.setForeground(new java.awt.Color(0, 0, 0));
        homeAddressLine1Label.setText("Address Line 1");

        homeAddressLine2Label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        homeAddressLine2Label.setForeground(new java.awt.Color(0, 0, 0));
        homeAddressLine2Label.setText("Address Line 2");

        homeAddressLine2.setBackground(new java.awt.Color(255, 255, 255));
        homeAddressLine2.setToolTipText("Enter the Address Line 2");
        homeAddressLine2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        homeUnitLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        homeUnitLabel.setForeground(new java.awt.Color(0, 0, 0));
        homeUnitLabel.setText("Unit Number");

        homeUnit.setBackground(new java.awt.Color(255, 255, 255));
        homeUnit.setToolTipText("Enter the Unit Number");
        homeUnit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        homeZipLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        homeZipLabel.setForeground(new java.awt.Color(0, 0, 0));
        homeZipLabel.setText("Zip Code");

        homeZip.setBackground(new java.awt.Color(255, 255, 255));
        homeZip.setToolTipText("Enter the Zip Code");
        homeZip.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        homeCountryLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        homeCountryLabel.setForeground(new java.awt.Color(0, 0, 0));
        homeCountryLabel.setText("Country");

        homeStateLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        homeStateLabel.setForeground(new java.awt.Color(0, 0, 0));
        homeStateLabel.setText("State");

        homeCityLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        homeCityLabel.setForeground(new java.awt.Color(0, 0, 0));
        homeCityLabel.setText("City");

        homeCountry.setBackground(new java.awt.Color(255, 255, 255));
        homeCountry.setForeground(new java.awt.Color(0, 0, 0));
        homeCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
        homeCountry.setSelectedItem(" -- Select Country --");
        homeCountry.setToolTipText("Select the Country");
        homeCountry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 240)));
        homeCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                homeCountryItemStateChanged(evt);
            }
        });
        homeCountry.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                homeCountryInputMethodTextChanged(evt);
            }
        });

        homeState.setBackground(new java.awt.Color(255, 255, 255));
        homeState.setForeground(new java.awt.Color(0, 0, 0));
        homeState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
        homeState.setToolTipText("Select the State");
        homeState.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 240)));
        homeState.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                homeStateItemStateChanged(evt);
            }
        });

        homeCity.setBackground(new java.awt.Color(255, 255, 255));
        homeCity.setForeground(new java.awt.Color(0, 0, 0));
        homeCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --", "New York City", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "San Francisco", "Columbus", "Fort Worth", "Charlotte", "Indianapolis", "Seattle", "Denver", "Washington, D.C.", "Boston", "El Paso", "Detroit", "Nashville", "Portland", "Oklahoma City", "Las Vegas", "Louisville", "Baltimore", "Milwaukee", "Albuquerque", "Tucson", "Fresno", "Sacramento", "Kansas City", "Mesa", "Virginia Beach", "Atlanta", "Colorado Springs", "Omaha", "Raleigh", "Miami", "Cleveland", "Tulsa", "Oakland", "Minneapolis", "Wichita", "Arlington", "New Orleans", "Bakersfield" }));
        homeCity.setToolTipText("Select the City");
        homeCity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 240)));

        homePhone.setBackground(new java.awt.Color(255, 255, 255));
        homePhone.setToolTipText("Enter your Phone Number");
        homePhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        homePhoneLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        homePhoneLabel.setForeground(new java.awt.Color(0, 0, 0));
        homePhoneLabel.setText("Phone Number");

        javax.swing.GroupLayout homeAddressPanelLayout = new javax.swing.GroupLayout(homeAddressPanel);
        homeAddressPanel.setLayout(homeAddressPanelLayout);
        homeAddressPanelLayout.setHorizontalGroup(
            homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeAddressPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeAddressPanelLayout.createSequentialGroup()
                        .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeUnitLabel)
                            .addComponent(homeUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeZip, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(homeZipLabel)))
                    .addComponent(homeAddressLine2Label)
                    .addComponent(homeAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeAddressLine1Label)
                    .addComponent(homeAddressTitle)
                    .addComponent(homeAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(homeAddressPanelLayout.createSequentialGroup()
                        .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homeAddressPanelLayout.createSequentialGroup()
                                .addComponent(homeCountryLabel)
                                .addGap(152, 152, 152))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeAddressPanelLayout.createSequentialGroup()
                                .addComponent(homeCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeStateLabel)
                            .addComponent(homeState, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeCityLabel)
                            .addComponent(homeCity, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(homeAddressHelper, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(homeAddressPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homePhoneLabel)
                            .addComponent(homePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        homeAddressPanelLayout.setVerticalGroup(
            homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeAddressPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeAddressPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(homeAddressHelper))
                    .addComponent(homeAddressTitle))
                .addGap(34, 34, 34)
                .addComponent(homeAddressLine1Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(homeAddressPanelLayout.createSequentialGroup()
                        .addComponent(homeStateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(homeCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(homeState, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(homeCity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(homeAddressPanelLayout.createSequentialGroup()
                        .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(homeAddressPanelLayout.createSequentialGroup()
                                .addComponent(homeAddressLine2Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(homeAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(homeAddressPanelLayout.createSequentialGroup()
                                        .addComponent(homeZipLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(homeZip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(homeAddressPanelLayout.createSequentialGroup()
                                        .addComponent(homeUnitLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(homeUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(homeCountryLabel))
                            .addComponent(homeCityLabel))
                        .addGap(34, 34, 34)))
                .addComponent(homePhoneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        formContainerPanel.add(homeAddressPanel, java.awt.BorderLayout.CENTER);

        personalInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        personalInfoPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));
        personalInfoPanel.setPreferredSize(new java.awt.Dimension(650, 370));

        personalInfoTitle.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        personalInfoTitle.setForeground(new java.awt.Color(0, 0, 0));
        personalInfoTitle.setText("Personal Information");

        personalInfoHelper.setText("Enter the person's basic details");

        firstNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        firstNameLabel.setText("First Name");

        firstName.setBackground(new java.awt.Color(255, 255, 255));
        firstName.setToolTipText("Enter the First Name");
        firstName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        lastName.setBackground(new java.awt.Color(255, 255, 255));
        lastName.setToolTipText("Enter the Last Name");
        lastName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        lastNameLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lastNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        lastNameLabel.setText("Last Name");

        dobLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        dobLabel.setForeground(new java.awt.Color(0, 0, 0));
        dobLabel.setText("Date of Birth");

        dob.setBackground(new java.awt.Color(255, 255, 255));
        dob.setForeground(new java.awt.Color(0, 0, 0));
        dob.setToolTipText("Enter the Date of Birth");

        ageLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        ageLabel.setForeground(new java.awt.Color(0, 0, 0));
        ageLabel.setText("Age");

        age.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        age.setToolTipText("Enter the age");
        age.setBorder(null);

        ssnLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        ssnLabel.setForeground(new java.awt.Color(0, 0, 0));
        ssnLabel.setText("Social Security Number");

        ssn.setBackground(new java.awt.Color(255, 255, 255));
        ssn.setToolTipText("Enter the Social Security Number");
        ssn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        isMarried.setBackground(new java.awt.Color(255, 255, 255));
        isMarried.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        isMarried.setForeground(new java.awt.Color(0, 0, 0));
        isMarried.setText("Is Married");
        isMarried.setToolTipText("Check if you're married");
        isMarried.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        salaryLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        salaryLabel.setForeground(new java.awt.Color(0, 0, 0));
        salaryLabel.setText("Salary");

        salary.setBackground(new java.awt.Color(255, 255, 255));
        salary.setToolTipText("Enter your Salary");
        salary.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        creditScoreLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        creditScoreLabel.setForeground(new java.awt.Color(0, 0, 0));
        creditScoreLabel.setText("Credit Score");

        creditScore.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        creditScore.setToolTipText("Enter your Credit Score");
        creditScore.setBorder(null);

        javax.swing.GroupLayout personalInfoPanelLayout = new javax.swing.GroupLayout(personalInfoPanel);
        personalInfoPanel.setLayout(personalInfoPanelLayout);
        personalInfoPanelLayout.setHorizontalGroup(
            personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalInfoPanelLayout.createSequentialGroup()
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salaryLabel)
                            .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creditScoreLabel)
                            .addComponent(creditScore)))
                    .addComponent(isMarried)
                    .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(personalInfoPanelLayout.createSequentialGroup()
                            .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(firstNameLabel)
                                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameLabel)))
                        .addGroup(personalInfoPanelLayout.createSequentialGroup()
                            .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dobLabel)
                                .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ageLabel))
                            .addGap(18, 18, 18)
                            .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ssnLabel)
                                .addComponent(ssn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(personalInfoHelper, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(personalInfoTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        personalInfoPanelLayout.setVerticalGroup(
            personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(personalInfoPanelLayout.createSequentialGroup()
                        .addComponent(lastNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalInfoPanelLayout.createSequentialGroup()
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(personalInfoHelper))
                            .addGroup(personalInfoPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(personalInfoTitle)))
                        .addGap(39, 39, 39)
                        .addComponent(firstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dobLabel)
                    .addComponent(ageLabel)
                    .addComponent(ssnLabel))
                .addGap(4, 4, 4)
                .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(isMarried)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(personalInfoPanelLayout.createSequentialGroup()
                        .addComponent(creditScoreLabel)
                        .addGap(34, 34, 34))
                    .addGroup(personalInfoPanelLayout.createSequentialGroup()
                        .addComponent(salaryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creditScore, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        formContainerPanel.add(personalInfoPanel, java.awt.BorderLayout.PAGE_START);

        workAddressPanel.setBackground(new java.awt.Color(255, 255, 255));
        workAddressPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));
        workAddressPanel.setPreferredSize(new java.awt.Dimension(650, 520));

        workAddressTitle.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        workAddressTitle.setForeground(new java.awt.Color(0, 0, 0));
        workAddressTitle.setText("Work Address");

        workAddressHelper.setText("Enter the person's work address details");

        workAddressLine1Label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        workAddressLine1Label.setForeground(new java.awt.Color(0, 0, 0));
        workAddressLine1Label.setText("Address Line 1");

        workAddressLine1.setBackground(new java.awt.Color(255, 255, 255));
        workAddressLine1.setToolTipText("Enter the Address Line 1");
        workAddressLine1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        workAddressLine2Label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        workAddressLine2Label.setForeground(new java.awt.Color(0, 0, 0));
        workAddressLine2Label.setText("Address Line 2");

        workAddressLine2.setBackground(new java.awt.Color(255, 255, 255));
        workAddressLine2.setToolTipText("Enter the Address Line 2");
        workAddressLine2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        workUnitLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        workUnitLabel.setForeground(new java.awt.Color(0, 0, 0));
        workUnitLabel.setText("Unit Number");

        workUnit.setBackground(new java.awt.Color(255, 255, 255));
        workUnit.setToolTipText("Enter the Unit Number");
        workUnit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        workZipLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        workZipLabel.setForeground(new java.awt.Color(0, 0, 0));
        workZipLabel.setText("Zip Code");

        workZip.setBackground(new java.awt.Color(255, 255, 255));
        workZip.setToolTipText("Enter the Zip Code");
        workZip.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        workCountryLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        workCountryLabel.setForeground(new java.awt.Color(0, 0, 0));
        workCountryLabel.setText("Country");

        workCountry.setBackground(new java.awt.Color(255, 255, 255));
        workCountry.setForeground(new java.awt.Color(0, 0, 0));
        workCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
        workCountry.setToolTipText("Select the Country");
        workCountry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 240)));
        workCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                workCountryItemStateChanged(evt);
            }
        });

        workStateLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        workStateLabel.setForeground(new java.awt.Color(0, 0, 0));
        workStateLabel.setText("State");

        workState.setBackground(new java.awt.Color(255, 255, 255));
        workState.setForeground(new java.awt.Color(0, 0, 0));
        workState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
        workState.setToolTipText("Select the State");
        workState.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 240)));
        workState.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                workStateItemStateChanged(evt);
            }
        });

        workCityLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        workCityLabel.setForeground(new java.awt.Color(0, 0, 0));
        workCityLabel.setText("City");

        workCity.setBackground(new java.awt.Color(255, 255, 255));
        workCity.setForeground(new java.awt.Color(0, 0, 0));
        workCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select --", "New York City", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "San Francisco", "Columbus", "Fort Worth", "Charlotte", "Indianapolis", "Seattle", "Denver", "Washington, D.C.", "Boston", "El Paso", "Detroit", "Nashville", "Portland", "Oklahoma City", "Las Vegas", "Louisville", "Baltimore", "Milwaukee", "Albuquerque", "Tucson", "Fresno", "Sacramento", "Kansas City", "Mesa", "Virginia Beach", "Atlanta", "Colorado Springs", "Omaha", "Raleigh", "Miami", "Cleveland", "Tulsa", "Oakland", "Minneapolis", "Wichita", "Arlington", "New Orleans", "Bakersfield" }));
        workCity.setToolTipText("Select the City");
        workCity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 240)));

        workPhoneLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        workPhoneLabel.setForeground(new java.awt.Color(0, 0, 0));
        workPhoneLabel.setText("Phone Number");

        workPhone.setBackground(new java.awt.Color(255, 255, 255));
        workPhone.setToolTipText("Enter your Phone Number");
        workPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 240), 2, true));

        submitBtn.setBackground(new java.awt.Color(0, 0, 0));
        submitBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Submit");
        submitBtn.setBorder(null);
        submitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        submitBtn.setIconTextGap(3);
        submitBtn.setMargin(new java.awt.Insets(10, 14, 3, 14));
        submitBtn.setVerifyInputWhenFocusTarget(false);
        submitBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitBtnMouseExited(evt);
            }
        });
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout workAddressPanelLayout = new javax.swing.GroupLayout(workAddressPanel);
        workAddressPanel.setLayout(workAddressPanelLayout);
        workAddressPanelLayout.setHorizontalGroup(
            workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAddressPanelLayout.createSequentialGroup()
                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workAddressPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(workAddressPanelLayout.createSequentialGroup()
                                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(workUnitLabel)
                                    .addComponent(workUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(workZip, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(workZipLabel)))
                            .addComponent(workAddressLine2Label)
                            .addComponent(workAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workAddressLine1Label)
                            .addComponent(workAddressTitle)
                            .addComponent(workAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(workAddressPanelLayout.createSequentialGroup()
                                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(workAddressPanelLayout.createSequentialGroup()
                                        .addComponent(workCountryLabel)
                                        .addGap(152, 152, 152))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workAddressPanelLayout.createSequentialGroup()
                                        .addComponent(workCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(workStateLabel)
                                    .addComponent(workState, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(workCityLabel)
                                    .addComponent(workCity, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(workAddressHelper, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(workAddressPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(workPhoneLabel)
                                    .addComponent(workPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(workAddressPanelLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        workAddressPanelLayout.setVerticalGroup(
            workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workAddressPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workAddressPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(workAddressHelper))
                    .addComponent(workAddressTitle))
                .addGap(34, 34, 34)
                .addComponent(workAddressLine1Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(workAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(workAddressPanelLayout.createSequentialGroup()
                        .addComponent(workStateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(workCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workState, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workCity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(workAddressPanelLayout.createSequentialGroup()
                        .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(workAddressPanelLayout.createSequentialGroup()
                                .addComponent(workAddressLine2Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(workAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(workAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(workAddressPanelLayout.createSequentialGroup()
                                        .addComponent(workZipLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(workZip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(workAddressPanelLayout.createSequentialGroup()
                                        .addComponent(workUnitLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(workUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(workCountryLabel))
                            .addComponent(workCityLabel))
                        .addGap(34, 34, 34)))
                .addComponent(workPhoneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(workPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        formContainerPanel.add(workAddressPanel, java.awt.BorderLayout.PAGE_END);

        mainPanel.add(formContainerPanel);

        scrollPane.setViewportView(mainPanel);

        splitPane.setRightComponent(scrollPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
	mainFramePanel.remove(this);
	
	try {
		Component[] panelStack = mainFramePanel.getComponents();
		JPanel lastPanel = (JPanel) panelStack[panelStack.length - 1];

		DashBoard dashBoard = (DashBoard) lastPanel;
		dashBoard.setDashboardDetails();
	} catch (Exception e) {}
	
	CardLayout layout = (CardLayout) mainFramePanel.getLayout();
	layout.previous(mainFramePanel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        // TODO add your handling code here:
	backBtn.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        // TODO add your handling code here:
	backBtn.setBackground(Color.BLACK);
    }//GEN-LAST:event_backBtnMouseExited

    private void submitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_submitBtnMouseEntered

    private void submitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_submitBtnMouseExited

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
	//Form validation for mandatory fields
	if(!isFormValid()) {
		return;
	}
	
	Person person = personDirectory.addPerson();
	
	// Personal Info
	person.setFirstName(firstName.getText());
	person.setLastName(lastName.getText());
	person.setDateOfBirth(dob.getDate());
	person.setAge((int) age.getValue());
	person.setIsMarried(isMarried.isSelected());
	person.setSocialSecurityNumber(Long.parseLong(ssn.getText()));
	person.setSalary(Double.parseDouble(salary.getText()));
	person.setCreditScore((int) creditScore.getValue());
	
	// Home Address
	person.setHomeAddressLine1(homeAddressLine1.getText());
	person.setHomeAddressLine2(homeAddressLine2.getText());
	person.setHomeUnitNumber(homeUnit.getText());
	person.setHomeCountry(homeCountry.getSelectedItem().toString());
	person.setHomeState(homeState.getSelectedItem().toString());
	person.setHomeCity(homeCity.getSelectedItem().toString());
	person.setHomePhoneNumber(homePhone.getText());
	person.setHomeZipCode(homeZip.getText());
	
	// Work Address
	person.setWorkAddressLine1(workAddressLine1.getText());
	person.setWorkAddressLine2(workAddressLine2.getText());
	person.setWorkUnitNumber(workUnit.getText());
	person.setWorkCountry(workCountry.getSelectedItem().toString());
	person.setWorkState(workState.getSelectedItem().toString());
	person.setWorkCity(workCity.getSelectedItem().toString());
	person.setWorkPhoneNumber(workPhone.getText());
	person.setWorkZipCode(workZip.getText());
	
	JOptionPane.showMessageDialog(this, "Person information saved successfully!", "Form Saved", JOptionPane.INFORMATION_MESSAGE);

	//Clear Fields
	
	// Personal Info Fields
	firstName.setText("");
	lastName.setText("");
	dob.setDate(null);
	isMarried.setSelected(false);
	age.setValue(1);
	ssn.setText("");
	creditScore.setValue(1);
	salary.setText("");

	// Home Address Fields
	homeAddressLine1.setText("");
	homeAddressLine2.setText("");
	homeUnit.setText("");
	homeCountry.setSelectedItem("-- Select --");
	homeState.setSelectedItem("-- Select --");
	homeCity.setSelectedItem("-- Select --");
	homeZip.setText("");
	homePhone.setText("");

	// Work Address Fields
	workAddressLine1.setText("");
	workAddressLine2.setText("");
	workUnit.setText("");
	workCountry.setSelectedItem("-- Select --");
	workState.setSelectedItem("-- Select --");
	workCity.setSelectedItem("-- Select --");
	workZip.setText("");
	workPhone.setText("");
    }//GEN-LAST:event_submitBtnActionPerformed

    private void homeCountryInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_homeCountryInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_homeCountryInputMethodTextChanged

    private void homeCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_homeCountryItemStateChanged
        // TODO add your handling code here:
	String homeCountryString = homeCountry.getSelectedItem().toString();
	
	String url = "https://www.universal-tutorial.com/api/states/" + homeCountryString;
	try {
		JSONArray object = new JSONArray(sendGetRequest(url).toString());
		DefaultComboBoxModel<String> stateModel = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> cityModel = new DefaultComboBoxModel<>();
		stateModel.addElement("-- Select --");
		cityModel.addElement("-- Select --");
		
		for(int i=0;i<object.length();i++) {
			JSONObject stateObject = object.getJSONObject(i);
			String stateName = stateObject.getString("state_name");
			stateModel.addElement(stateName);
		}
		
		homeState.setModel(stateModel);
		homeCity.setModel(cityModel);
		
	} catch (Exception ex) {
		System.out.println(ex.toString());
	}
    }//GEN-LAST:event_homeCountryItemStateChanged

    private void homeStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_homeStateItemStateChanged
        // TODO add your handling code here:
	String homeStateString = homeState.getSelectedItem().toString();
	
	String url = "https://www.universal-tutorial.com/api/cities/" + homeStateString;
	try {
		JSONArray object = new JSONArray(sendGetRequest(url).toString());
		DefaultComboBoxModel<String> cityModel = new DefaultComboBoxModel<>();
		cityModel.addElement("-- Select --");
		
		for(int i=0;i<object.length();i++) {
			JSONObject stateObject = object.getJSONObject(i);
			String stateName = stateObject.getString("city_name");
			cityModel.addElement(stateName);
		}
		
		homeCity.setModel(cityModel);
		
	} catch (Exception ex) {
		System.out.println(ex.toString());
	}
    }//GEN-LAST:event_homeStateItemStateChanged

    private void workCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_workCountryItemStateChanged
        // TODO add your handling code here:
	String workCountryString = workCountry.getSelectedItem().toString();
	
	String url = "https://www.universal-tutorial.com/api/states/" + workCountryString;
	try {
		JSONArray object = new JSONArray(sendGetRequest(url).toString());
		DefaultComboBoxModel<String> stateModel = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> cityModel = new DefaultComboBoxModel<>();
		stateModel.addElement("-- Select --");
		cityModel.addElement("-- Select --");
		
		for(int i=0;i<object.length();i++) {
			JSONObject stateObject = object.getJSONObject(i);
			String stateName = stateObject.getString("state_name");
			stateModel.addElement(stateName);
		}
		
		workState.setModel(stateModel);
		
	} catch (Exception ex) {
		System.out.println(ex.toString());
	}
    }//GEN-LAST:event_workCountryItemStateChanged

    private void workStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_workStateItemStateChanged
        // TODO add your handling code here:
	String workStateString = workState.getSelectedItem().toString();
	
	String url = "https://www.universal-tutorial.com/api/cities/" + workStateString;
	try {
		JSONArray object = new JSONArray(sendGetRequest(url).toString());
		DefaultComboBoxModel<String> cityModel = new DefaultComboBoxModel<>();
		cityModel.addElement("-- Select --");
		
		for(int i=0;i<object.length();i++) {
			JSONObject stateObject = object.getJSONObject(i);
			String stateName = stateObject.getString("city_name");
			cityModel.addElement(stateName);
		}
		
		workCity.setModel(cityModel);
		
	} catch (Exception ex) {
		System.out.println(ex.toString());
	}
    }//GEN-LAST:event_workStateItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner age;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JSpinner creditScore;
    private javax.swing.JLabel creditScoreLabel;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JPanel formContainerPanel;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel homeAddressHelper;
    private javax.swing.JTextField homeAddressLine1;
    private javax.swing.JLabel homeAddressLine1Label;
    private javax.swing.JTextField homeAddressLine2;
    private javax.swing.JLabel homeAddressLine2Label;
    private javax.swing.JPanel homeAddressPanel;
    private javax.swing.JLabel homeAddressTitle;
    private javax.swing.JComboBox<String> homeCity;
    private javax.swing.JLabel homeCityLabel;
    private javax.swing.JComboBox<String> homeCountry;
    private javax.swing.JLabel homeCountryLabel;
    private javax.swing.JTextField homePhone;
    private javax.swing.JLabel homePhoneLabel;
    private javax.swing.JComboBox<String> homeState;
    private javax.swing.JLabel homeStateLabel;
    private javax.swing.JTextField homeUnit;
    private javax.swing.JLabel homeUnitLabel;
    private javax.swing.JTextField homeZip;
    private javax.swing.JLabel homeZipLabel;
    private javax.swing.JCheckBox isMarried;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel personalInfoHelper;
    private javax.swing.JPanel personalInfoPanel;
    private javax.swing.JLabel personalInfoTitle;
    private javax.swing.JTextField salary;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JTextField ssn;
    private javax.swing.JLabel ssnLabel;
    private javax.swing.JButton submitBtn;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel workAddressHelper;
    private javax.swing.JTextField workAddressLine1;
    private javax.swing.JLabel workAddressLine1Label;
    private javax.swing.JTextField workAddressLine2;
    private javax.swing.JLabel workAddressLine2Label;
    private javax.swing.JPanel workAddressPanel;
    private javax.swing.JLabel workAddressTitle;
    private javax.swing.JComboBox<String> workCity;
    private javax.swing.JLabel workCityLabel;
    private javax.swing.JComboBox<String> workCountry;
    private javax.swing.JLabel workCountryLabel;
    private javax.swing.JTextField workPhone;
    private javax.swing.JLabel workPhoneLabel;
    private javax.swing.JComboBox<String> workState;
    private javax.swing.JLabel workStateLabel;
    private javax.swing.JTextField workUnit;
    private javax.swing.JLabel workUnitLabel;
    private javax.swing.JTextField workZip;
    private javax.swing.JLabel workZipLabel;
    // End of variables declaration//GEN-END:variables
}

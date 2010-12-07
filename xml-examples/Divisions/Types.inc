<xs:schema targetNamespace="http://www.felix.org/Types" xmlns:fg="http://www.FGolubov.com/XMLEditor" xmlns="http://www.felix.org/Types" xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified">
	<xs:attributeGroup name="MyAttributes">
		<xs:attribute name="first" type="xs:string" default="Default Value"/>
		<xs:attribute name="second" type="xs:string"/>
		<xs:attribute name="third" type="xs:string"/>
	</xs:attributeGroup>

	<xs:simpleType name="LanguageType">
		<xs:restriction base="xs:string">
			<xs:enumeration value="English"/>
			<xs:enumeration value="Spanich"/>
			<xs:enumeration value="German"/>
			<xs:enumeration value="Russian"/>
		</xs:restriction>
	</xs:simpleType>

	<xs:element name="File" type="xs:string" abstract="true"/>
	
	<xs:element name="document-url" type="xs:string" substitutionGroup="File"/>
	
	<xs:element name="Text-File" substitutionGroup="File">
		<xs:annotation>
			<xs:appinfo>
				<fg:node-info
					editor-id="FileDialog" 
					exposed="true"
					message="Any Text File">
					<fg:param>txt|doc|rtf|Text files: *.txt, *.doc, *.rtf</fg:param>
				</fg:node-info>
			</xs:appinfo>
		</xs:annotation>
	      <xs:complexType>
			<xs:simpleContent>
				<xs:extension base="xs:string">
					<xs:attribute name="language" type="LanguageType" use="required"/>
				</xs:extension>
			</xs:simpleContent>
	      </xs:complexType>
	</xs:element>

	<xs:element name="Image-File" substitutionGroup="File">
		<xs:annotation>
			<xs:appinfo>
				<fg:node-info
					editor-id="FileDialog" 
					exposed="true">
					<fg:param>gif|jpg|tif|Image files: *.gif, *.jpg, *.tif</fg:param>
				</fg:node-info>
			</xs:appinfo>
		</xs:annotation>
	      <xs:complexType>
			<xs:simpleContent>
				<xs:extension base="xs:string">
					<xs:attribute name="image-width" type="xs:integer" use="required"/>
					<xs:attribute name="image-height" type="xs:integer" use="required"/>
				</xs:extension>
			</xs:simpleContent>
	      </xs:complexType>
	</xs:element>

	
	<xs:simpleType name="String80Type">
		<xs:restriction base="xs:string">
			<xs:minLength value="0"/>
			<xs:maxLength value="80"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:simpleType name="String20Type">
		<xs:restriction base="xs:string">
			<xs:minLength value="0"/>
			<xs:maxLength value="20"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:simpleType name="CharType">
		<xs:restriction base="xs:string">
			<xs:minLength value="1"/>
			<xs:maxLength value="1"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:simpleType name="PerPeriodType">
		<xs:restriction base="xs:string">
			<xs:enumeration value="perHour"/>
			<xs:enumeration value="perDay"/>
			<xs:enumeration value="perMonth"/>
			<xs:enumeration value="perYear"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:simpleType name="DegreeType">
		<xs:restriction base="xs:string">
			<xs:enumeration value="Bachelor"/>
			<xs:enumeration value="Master"/>
			<xs:enumeration value="MBA"/>
			<xs:enumeration value="PhD"/>
			<xs:enumeration value="None"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:simpleType name="YesNoType">
		<xs:annotation>
			<xs:appinfo>
				<fg:node-info
					editor-class="com.fg.ftreenodes.FCheckBox" 
					exposed="true">
					<fg:param>Yes</fg:param>
					<fg:param>No</fg:param>
				</fg:node-info>
			</xs:appinfo>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="Yes"/>
			<xs:enumeration value="No"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:simpleType name="GenderType">
		<xs:restriction base="xs:string">
			<xs:enumeration value="Male"/>
			<xs:enumeration value="Female"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:simpleType name="StateType">
		<xs:restriction base="xs:string">
			<xs:enumeration value="AR"/>
			<xs:enumeration value="AL"/>
			<xs:enumeration value="CA"/>
			<xs:enumeration value="MA"/>
			<xs:enumeration value="NJ"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:simpleType name="SSNType">
		<xs:restriction base="xs:string">
			<xs:pattern value="[0-9]{3}-[0-9]{2}-[0-9]{4}"/>
		</xs:restriction>
	</xs:simpleType>
	<xs:complexType name="NameType">
		<xs:sequence>
			<xs:element name="FirstName" type="String20Type"/>
			<xs:element name="MiddleInitial" type="CharType" minOccurs="0"/>
			<xs:element name="LastName" type="String20Type">
				<xs:annotation>
					<xs:appinfo>
 						<fg:node-info exposed="true"/>
					</xs:appinfo>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
	</xs:complexType>
	<xs:complexType name="AddressType">
		<xs:sequence>
			<xs:element name="Street" type="String20Type"/>
			<xs:element name="Town" type="String20Type"/>
			<xs:element name="City" type="String20Type" minOccurs="0"/>
			<xs:element name="State" type="StateType"/>
			<xs:element name="ZipCode" type="xs:integer"/>
		</xs:sequence>
	</xs:complexType>
	<xs:complexType name="EContactType">
		<xs:all>
			<xs:element name="Email" type="xs:string" minOccurs="0"/>
			<xs:element name="HomeTel" type="xs:integer" minOccurs="0"/>
			<xs:element name="WorkTel" type="xs:integer" minOccurs="0"/>
			<xs:element name="CellPhone" type="xs:integer" minOccurs="0"/>
			<xs:element name="Fax" type="xs:integer" minOccurs="0"/>
			<xs:element name="Pager" type="xs:integer" minOccurs="0"/>
		</xs:all>
		<xs:attribute name="Publish" type="YesNoType" use="required"/>
	</xs:complexType>
	<xs:complexType name="EmployeeInfoType">
		<xs:sequence>
			<xs:element name="Address" type="AddressType" minOccurs="0"/>
			<xs:element name="EContact" type="EContactType" minOccurs="0"/>
			<xs:element name="Gender" type="GenderType" minOccurs="0"/>
			<xs:element name="DayOfBirth" type="xs:date" minOccurs="0"/>
		</xs:sequence>
		<xs:attribute name="SSN" type="SSNType"/>
	</xs:complexType>
	<xs:element name="Name" type="NameType">
		<xs:annotation>
			<xs:appinfo>
				<fg:node-info exposed="true"/>
			</xs:appinfo>
		</xs:annotation>
	</xs:element>
	<xs:element name="SecondProb">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="Name" type="NameType" minOccurs="3" maxOccurs="6"/>
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	<xs:attribute name="globalAttr" type="xs:string"/>
</xs:schema>

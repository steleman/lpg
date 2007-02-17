This package contains a base XML parser and an XML parser with the
Namespace extension.

    . XmlCharSubsets.g   - Subsets of Char that are needed for the base XML parser
    . XmlNSCharSubsets.g - Additional subsets of Char that are needed for the NS extension
    . XmlNSParser.g      - The Namespace XML parser
    . XmlParser.g        - The base XML parser
    . XmlUtil.g          - Functions needed for scanning XML



The test examples are:

    . datatypes.xml
    . gpo.xml        - A UTF-8 file
    . gpotab.xml     - Same as above but it contains tab characters and an error
    . ipo3.xml       - An example that conforms to the IPO schema
    . jmdict.xml     - a 20MB example that uses Extended Ascii char set.
    . lll.xml
    . po.xml
    . po2.xml       
    . potato.xml
    . publisher.xml
    . test.xml       - a small test containing a "bad tag" error.
